package pl.stqa.pft.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "address_in_groups")

public class GroupMemberData {

  @Id
  @Column(name = "group_id")
  private int groupId;

  @Column(name = "id")
  private int contactId;

  public int getContactId() {
    return contactId;
  }

  public int getGroupId() {
    return groupId;
  }

  public GroupMemberData withGroupId(int groupId) {
    this.groupId = groupId;
    return this;
  }

  public GroupMemberData withContactId(int contactId) {
    this.contactId = contactId;
    return this;
  }

  @Override
  public String toString() {
    return "GroupMembers{" +
            "groupId=" + groupId +
            ", contactId=" + contactId +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupMemberData that = (GroupMemberData) o;
    return groupId == that.groupId &&
            contactId == that.contactId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupId, contactId);
  }
}

