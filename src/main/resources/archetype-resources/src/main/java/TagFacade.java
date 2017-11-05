package ${package};

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class TagFacade {
	@PersistenceContext(unitName="${artifactId}")
	private EntityManager em;

	public List<Tag> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Tag> cq = cb.createQuery(Tag.class);
		cq.select(cq.from(Tag.class));
		return em.createQuery(cq).getResultList();
	}
}
