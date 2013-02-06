/**
 * 
 */
package hibernateManagers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import hibernateEntities.User;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author shounoy
 * 
 */
@RunWith(PowerMockRunner.class)
// PowerMock‚Ì—˜—p‚ð�éŒ¾
@PrepareForTest({ ConnectionManager.class })
// ƒ‚ƒbƒNƒIƒuƒWƒFƒNƒg‚ð�ì‚éƒNƒ‰ƒX‚ð�éŒ¾
public class UserManagerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Configuration config = new AnnotationConfiguration();
		config.configure(new File(
				"C:\\Users\\Alex\\Desktop\\TEST_CharityWare\\test\\testSrc\\resources\\hibernate.cfg.xml"));
		SessionFactory factory = config.buildSessionFactory();
		Session hibernateSession = factory.openSession();

		ConnectionManager.setFactory(factory);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link hibernateManagers.UserManager#retrieve()}.
	 */
	@Test
	public void testRetrieve() {

		List<User> actual = UserManager.retrieve();

		assertEquals("lchirchop", actual.get(0).getUserName());
	}

	/**
	 * Test method for
	 * {@link hibernateManagers.UserManager#addUserSample(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testAddUserSample() {
		String name = "yuji";
		String pass = "nttdata";
		int EXISTED_USER_NUMBER_INADVANCE = 7;

		Integer actual = UserManager.addUserSample(name, pass);
		Integer expected = EXISTED_USER_NUMBER_INADVANCE
				+ UserManager.getUsersFromName(name).size();

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link hibernateManagers.UserManager#getUser(java.lang.Integer)}.
	 */
	@Test
	public void testGetUser() {

		PowerMockito.mockStatic(ConnectionManager.class);

		Integer id = 1;
		String name = "aaa";
		String pass = "bbb";

		User expected = new User(name, pass);
		PowerMockito.when(ConnectionManager.get(User.class, id)).thenReturn(
				expected);

		User actual = UserManager.getUser(id);

		assertEquals(expected, actual);
		assertEquals(expected.getUser_id(), actual.getUser_id());
		assertEquals(expected.getUserPassword(), actual.getUserPassword());

	}

	/**
	 * Test method for
	 * {@link hibernateManagers.UserManager#getUsersFromName(java.lang.String)}.
	 */
	@Test
	public void testGetUsersFromName() {
		String name = "lchirchop";
		List<User> actual = UserManager.getUsersFromName(name);

		assertEquals(name, actual.get(0).getUserName());

	}

	/**
	 * Test method for
	 * {@link hibernateManagers.UserManager#updateUserPassword(java.lang.Integer, java.lang.String)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateUserPassword() throws Exception {
		Integer userId = 8;
		String name = "yuji";
		String userPassword = "nttdata";
		UserManager.updateUserPassword(userId, userPassword);
		List<User> actual = UserManager.getUsersFromName(name);

		assertEquals(name, actual.get(0).getUserName());

	}

	/**
	 * Test method for {@link hibernateManagers.UserManager#getForms()}.
	 */
	@Test
	public void testGetForms() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link hibernateManagers.UserManager#getFormEntities(java.lang.String)}.
	 */
	@Test
	public void testGetFormEntities() {
		fail("Not yet implemented");
	}

}
