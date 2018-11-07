package pl.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class GroupMembers extends ForwardingSet<GroupMemberData> {
  private Set<GroupMemberData> delegate;

  public GroupMembers(Collection<GroupMemberData> groups) {
    this.delegate = new HashSet<GroupMemberData>(groups);
  }

  @Override
  protected Set<GroupMemberData> delegate() {
    return delegate;
  }

  public GroupMembers withAdded(GroupMemberData group) {
    GroupMembers groups = new GroupMembers(this);
    groups.add(group);
    return groups;
  }

  public GroupMembers without(GroupMemberData group) {
    GroupMembers groups = new GroupMembers(this);
    groups.remove(group);
    return groups;
  }
}