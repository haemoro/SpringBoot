package com.exam.haemo.repository;

import com.exam.haemo.entity.Resve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResveRepository extends JpaRepository<Resve, String> {
    //비워있어도 잘 작동함.
    // long 이 아니라 Long으로 작성. ex) int => Integer 같이 primitive형식 사용못함
    @Query(value = "SELECT CONCAT('RESVE_',DATE_FORMAT(now(), '%Y%m%d%H%i%s')) RESVE_NO FROM DUAL", nativeQuery = true)
    String getResveNo();

    // findBy뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능하다
//    public List<MemberVo> findById(String id);

//    public List<MemberVo> findByName(String name);

    //like검색도 가능
//    public List<MemberVo> findByNameLike(String keyword);
}