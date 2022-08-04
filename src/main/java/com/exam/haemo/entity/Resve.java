package com.exam.haemo.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="TB_RESVE")
public class Resve {

    @Id
    @Column(name = "RESVE_NO")
    private String resveNo;

    @Column(name = "RESVE_STTUS")
    private String resveSttus;

    @Column(name = "REG_DT")
    @CreatedDate
    private LocalDateTime regDt;

    @OneToMany
    @JoinColumn(name = "RESVE_NO", referencedColumnName = "RESVE_NO")
    private List<ResveItem> resveItems = new ArrayList<>();

//    @Transient
//    boolean isNew=true;
//
//
//    @Override
//    public String getId() {
//        return getResveNo();
//    }
//
//    @Override
//    public boolean isNew() {
//        // TODO Auto-generated method stub
//        return this.isNew;
//    }
//
//    @PostPersist
//    @PostLoad
//    public void modifyIsNew(){
//        this.isNew=false;
//    }




}