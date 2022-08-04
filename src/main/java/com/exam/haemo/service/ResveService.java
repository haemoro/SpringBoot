package com.exam.haemo.service;

import com.exam.haemo.entity.Resve;
import com.exam.haemo.repository.ResveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResveService {
    @Autowired
    private ResveRepository resveRepository;

//    public List<MemberVo> findAll() {
//        List<MemberVo> members = new ArrayList<>();
//        resveRepository.findAll().forEach(e -> members.add(e));
//        return members;
//    }
//
//    public Optional<MemberVo> findById(Long mbrNo) {
//        Optional<MemberVo> member = resveRepository.findById(mbrNo);
//        return member;
//    }
//
//    public void deleteById(Long mbrNo) {
//        resveRepository.deleteById(mbrNo);-
//    }

    public Resve save(Resve member) {
        member.setResveNo(resveRepository.getResveNo());
        resveRepository.save(member);
        return member;
    }

//    public void updateById(Long mbrNo, MemberVo member) {
//        Optional<MemberVo> e = resveRepository.findById(mbrNo);
//
//        if (e.isPresent()) {
//            e.get().setMbrNo(member.getMbrNo());
//            e.get().setId(member.getId());
//            e.get().setName(member.getName());
//            resveRepository.save(member);
//        }
//    }
}