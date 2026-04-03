package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void same_object_returns_true() {
        assert(team.equals(team));
    }

    @Test
    public void different_type_returns_false() {
        assert(!team.equals("test-team"));
    }

    @Test
    public void same_name_and_members_returns_true() {
        Team other = new Team("test-team");
        assert(team.equals(other));
    }

    @Test
    public void same_name_different_members_returns_false() {
        Team other = new Team("test-team");
        other.addMember("Alice");
        assert(!team.equals(other));
    }

    @Test
    public void different_name_same_members_returns_false() {
        Team other = new Team("other-team");
        assert(!team.equals(other));
    }

    @Test
    public void different_name_and_members_returns_false() {
        Team other = new Team("other-team");
        other.addMember("Alice");
        assert(!team.equals(other));
    }

    @Test
    public void same_name_and_members_hashcode_equals() {
        Team other = new Team("test-team");
        assert(team.hashCode() == other.hashCode());
    }

    @Test
    public void different_name_or_members_hashcode_not_equals() {
        Team other = new Team("other-team");
        assert(team.hashCode() != other.hashCode());
    }

}
