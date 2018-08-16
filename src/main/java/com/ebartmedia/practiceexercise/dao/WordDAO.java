package com.ebartmedia.practiceexercise.dao;
import com.ebartmedia.practiceexercise.model.Words;
import com.ebartmedia.practiceexercise.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class WordDAO {
@PersistenceContext
private EntityManager entityManager;
// @Autowired
// private WordRepository wordRepository;
public List<Words> getAll() {
// String hql = &quot;FROM Word as a ORDER BY a.id&quot;;
String hql = "FROM Word as w";
return (List<Words>) entityManager.createQuery(hql).getResultList();
// return wordRepository.getAll();
}
}
