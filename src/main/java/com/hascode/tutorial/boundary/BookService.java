package com.hascode.tutorial.boundary;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import com.hascode.tutorial.control.BillingService;
import com.hascode.tutorial.entity.Order;

public class BookService {

    private final BillingService billingService = new BillingService();
    private final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    private final KieBase kbase;
    private final StatelessKieSession ksession;

    public BookService() {
        kbuilder.add(ResourceFactory.newClassPathResource("rules/book-order.drl"), ResourceType.DRL);
        kbase = kbuilder.newKnowledgeBase();
        ksession = kbase.newStatelessKieSession();
    }

    public void order(String bookId, int quantity) {
        Order order = new Order(bookId, quantity);
        List<Object> environment = new ArrayList<>();
        environment.add(billingService);
        environment.add(order);
        ksession.execute(environment);
    }
}
