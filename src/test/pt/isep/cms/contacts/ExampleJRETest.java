package pt.isep.cms.contacts;

import com.google.gwt.event.shared.HandlerManager;
import junit.framework.TestCase;
import pt.isep.cms.contacts.client.ContactsServiceAsync;
import pt.isep.cms.contacts.client.presenter.ContactsPresenter;
import pt.isep.cms.contacts.shared.ContactDetails;

import java.util.ArrayList;

import static org.easymock.EasyMock.createStrictMock;

public class ExampleJRETest extends TestCase {
	private ContactsPresenter contactsPresenter;

	protected void setUp() {
		ContactsServiceAsync mockRpcService = createStrictMock(ContactsServiceAsync.class);
		HandlerManager eventBus = new HandlerManager(null);
		ContactsPresenter.Display mockDisplay = createStrictMock(ContactsPresenter.Display.class);
		contactsPresenter = new ContactsPresenter(mockRpcService, eventBus, mockDisplay);
	}

	public void testContactSort() {
		ArrayList<ContactDetails> contactDetails = new ArrayList<>();
		contactDetails.add(new ContactDetails("0", "c_contact"));
		contactDetails.add(new ContactDetails("1", "b_contact"));
		contactDetails.add(new ContactDetails("2", "a_contact"));
		contactsPresenter.setContactDetails(contactDetails);
		contactsPresenter.sortContactDetails();
		assertEquals("a_contact", contactsPresenter.getContactDetail(0).getDisplayName());
		assertEquals("b_contact", contactsPresenter.getContactDetail(1).getDisplayName());
		assertEquals("c_contact", contactsPresenter.getContactDetail(2).getDisplayName());
	}
}
