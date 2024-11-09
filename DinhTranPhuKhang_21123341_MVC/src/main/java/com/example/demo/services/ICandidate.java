package com.example.demo.services;


import com.example.demo.models.Candidate;
import com.example.demo.models.Skill;

import java.util.List;

public interface ICandidate {
    public Candidate findById(long id);
    List<Skill> suggestSkillsForCandidate(Long candidateId);
    public List<Candidate> findCandidatesBySkills(List<Skill> skills);
}
