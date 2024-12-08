package com.interview.practice.services;

import com.interview.practice.model.Library;
import com.interview.practice.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MemberService {

    private final Library library = new Library();

    public void addMember(Member member) {
        library.addMember(member);
    }

    public Set<Member> getAllMembers() {
        return library.getMembers();
    }

    public Member getMemberById(int memberId) {
        return library.getMembers().stream()
                .filter(member -> member.getId() == memberId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }
}