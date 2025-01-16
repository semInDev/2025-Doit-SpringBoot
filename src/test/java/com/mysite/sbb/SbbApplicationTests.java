package com.mysite.sbb;

import com.mysite.sbb.domain.Answer;
import com.mysite.sbb.domain.Question;
import com.mysite.sbb.repository.AnswerRepository;
import com.mysite.sbb.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa(){
		//1. testJpa로 데이터 만들어서 추가해보기(local server 끄고 실행)
		// -> 서버 실행하고, H2 DB에 추가 된 것 확인해보기(기본 제공 메서드: save())
/*		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("스프링 부트 모델 전문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);*/

/*		//2. findAll 활용하기(기본 제공 메서드)
		List<Question> all = questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());*/

/*		//3. findById 사용하기(기본 제공 메서드)
		Optional<Question> oq = questionRepository.findById(0);
		if(oq.isPresent()){
			Question q = oq.get();
			assertEquals("ssb가 무엇인가요?", q.getSubject());
		}*/

/*		//4. findBySubject 사용하기(기본 제공 메서드 아님!!!->리포지토리 인터페이스에 구현 필요)
		Question q = questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals("sbb가 무엇인가요?", q.getSubject());*/

/*
		//5. findBySubjectAndContent 사용하기(기본 제공 메서드 아님)
		Question q = questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다");
		assertEquals(1, q.getId());
*/
/*		//6.findBySubjectLike 사용하기(기본 제공 메서드 아님)
		List<Question> listQ = questionRepository.findBySubjectLike("sbb%");
		Question q = listQ.get(0);
		assertEquals(1, q.getId());*/

/*		//7. 질문 데이터 수정하기: assertTrue, isPresent
		Optional<Question> question = questionRepository.findById(1);
		assertTrue(question.isPresent());//false(null)면 오류가 발생하여 테스트가 종료됨
		Question q = question.get();
		q.setSubject("수정된 제목");//DB에서 확인해보면 수정된 것을 확인할 수 있음!
		this.questionRepository.save(q);*/

/*		//8. 질문 데이터 삭제하기: delete, count
		assertEquals(2, questionRepository.count());
		Optional<Question> question = questionRepository.findById(1);
		assertTrue(question.isPresent());
		Question q = question.get();
		this.questionRepository.delete(q);
		assertEquals(1, questionRepository.count());*/

/*		//9. 답변 데이터 저장하기:
		Optional<Question> question = questionRepository.findById(2);
		assertTrue(question.isPresent());
		Question q = question.get();

		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);
		a.setCreatedDate(LocalDateTime.now());
		answerRepository.save(a);
		assertEquals(1, answerRepository.count());*/

		//10. 답변 데이터 조회하기: 동일한 과정이라 생략

		//11. 답변 데이터를 통해 질문 데이터 찾기 -> 지금까지 배운 걸로 해결 가능
		//질문 데이터를 통해 답변 데이터 찾기 -> 지금까지 배운 코드로는 에러 발생
		//why? findById로 Question을 리턴 받으면 그 순간부터는 DB와의 연결이 끊어진 상태기때문에!!
		// => 따라서, @Transactional(: 메서드가 종료될 때까지 DB와의 연결을 유지)을 사용해야 함!
		Optional<Question> oq = questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answers = q.getAnswers();

		assertEquals(1, answers.size());
		assertEquals("네 자동으로 생성됩니다.", answers.get(0).getContent());

	}

}
