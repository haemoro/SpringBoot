package com.exam.haemo.entity.id;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ResveItemId implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private String resveNo;

    @EqualsAndHashCode.Include
    @Id
    private String resveSeq;

    @EqualsAndHashCode.Include
    @Id
    private String itemId;

    @EqualsAndHashCode.Include
    @Id
    private String itemNo;

    @EqualsAndHashCode.Include
    @Id
    private String itemUnitSeq;

}
