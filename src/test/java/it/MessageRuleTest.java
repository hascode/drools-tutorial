package it;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import com.hascode.tutorial.Message;

public class MessageRuleTest {
	KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

	@Test
	public void testName() throws Exception {
		kbuilder.add(ResourceFactory.newClassPathResource("rules/MessageSample.drl"), ResourceType.DRL);
		KieBase kbase = kbuilder.newKnowledgeBase();
		StatelessKieSession ksession = kbase.newStatelessKieSession();

		Message message = new Message();
		message.setMessage("Hello World");
		message.setStatus(Message.HELLO);
		ksession.execute(message);
	}
}
