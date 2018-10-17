package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
//    app.goTo().groupPage();
//    if (app.group().all().size() == 0) {
    if (app.db().groups().size() == 0){
    app.goTo().groupPage();
    app.group().create(new GroupData().withName(app.propReader("precondition.group.name"))
            .withHeader(app.propReader("precondition.group.header"))
            .withFooter(app.propReader("precondition.group.footer")));
  }
}

  @Test
  public void testGroupModification() {
//    Groups before = app.group().all();
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId())
            .withName(app.propReader("modified.group.name"))
            .withHeader(app.propReader("modified.group.header"))
            .withFooter(app.propReader("modified.group.footer"));
    app.goTo().groupPage();
    app.group().modify(group);
    assertEquals(app.group().count(), before.size());
//    Groups after = app.group().all();
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }
}
