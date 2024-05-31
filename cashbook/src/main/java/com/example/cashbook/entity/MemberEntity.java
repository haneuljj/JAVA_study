package com.example.cashbook.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Entity
@Table(name = "cashbook_member")
public class MemberEntity {

    @Id
    private String memberid;

    @Column(nullable = false)
    private String memberpw;

    @Column(nullable = false)
    private String membername;
    private boolean enabled;
    private String rolename;

    @OneToMany(
		mappedBy = "memberEntity", 
		cascade = CascadeType.REMOVE,
		orphanRemoval = true,
		fetch = FetchType.LAZY
		)
	// 딸려오는 댓글들의 정렬 설정
	@OrderBy("infonum asc")
	private List<CashbookEntity> cashbookEntity = new ArrayList<>();
}
