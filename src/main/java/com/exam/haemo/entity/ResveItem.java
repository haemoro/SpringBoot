package com.exam.haemo.entity;

import com.exam.haemo.entity.id.ResveItemId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="TB_RESVE_ITEM")
@IdClass(ResveItemId.class)
public class ResveItem {

    @Id
    @Column(name = "RESVE_NO")
    private String resveNo;

    @Id
    @Column(name = "RESVE_SEQ")
    private String resveSeq;

    @Id
    @Column(name = "ITEM_ID")
    private String itemId;

    @Id
    @Column(name = "ITEM_NO")
    private String itemNo;

    @Id
    @Column(name = "ITEM_UNIT_SEQ")
    private String itemUnitSeq;

    @Column(name = "GOODS_ID")
    private String GOODS_ID;

    @Column(name = "GOODS_NM")
    private String GOODS_NM;

    @Column(name = "ITEM_NM")
    private String ITEM_NM;

    @Column(name = "REG_DT")
    @CreatedDate
    private String regDt;

    @ManyToOne
    @JoinColumn(name="RESVE_NO", referencedColumnName="RESVE_NO")
    private Resve resve;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumns(value = {
//            @JoinColumn(name = "RESVE_NO", updatable = false, insertable = false),
//    }, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Resve resve;
}