package org.cccgermantown.web.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * A generic JPA DAO that can be used directly or as a base class for more specialized DAO's.
 */
@Repository
public class BaseJpaDaoImpl implements BaseJpaDao
{
    @PersistenceContext
    protected EntityManager entityManager;

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public <T> T findById(Class<T> entityClass, Object entityId)
    {
        Validate.notNull(entityClass);
        Validate.notNull(entityId);
        return entityManager.find(entityClass, entityId);
    }

    public <T> List<T> findAll(Class<T> entityClass)
    {
        Validate.notNull(entityClass);
        return query("select type from " + StringUtils.unqualify(entityClass.getName()) + " type");
    }

    @SuppressWarnings({"unchecked"})
    public <T> List<T> findByNamedProperties(Class<T> entityClass, Map<String, ?> params)
    {
        Validate.notNull(entityClass);
        Validate.notEmpty(params);
        StringBuilder queryStringBuilder = new StringBuilder("select type from " + StringUtils.unqualify(entityClass.getName()) + " type where ");

        Iterator iterator = params.keySet().iterator();
        int index = 0;
        while (iterator.hasNext())
        {
            String propertyName = (String) iterator.next();
            if (index > 0)
            {
                queryStringBuilder.append(" and ");
            }
            queryStringBuilder.append("(type.").append(propertyName).append(" = :").append(propertyName).append(')');
            index++;
        }

        return queryByNamedParams(queryStringBuilder.toString(), params);
    }

    public <T> T findUniqueByNamedProperties(Class<T> entityClass, Map<String, ?> params)
    {
        Validate.notNull(entityClass);
        Validate.notEmpty(params);
        List<T> resultList = findByNamedProperties(entityClass, params);
        Validate.isTrue(resultList.isEmpty() || resultList.size() == 1,
                "Found more than one persistent instance of type " + StringUtils.unqualify(entityClass.getName() + " with parameters " + params.toString()));
        return resultList.size() == 1 ? resultList.get(0) : null;
    }

    public <T> List<T> queryByNamedParams(String queryString, Map<String, ?> params)
    {
        Validate.notEmpty(queryString);
        Validate.notEmpty(params);
        return executeQueryWithNamedParams(entityManager.createQuery(queryString), params);
    }

    public <T> List<T> queryByNamedQueryAndNamedParams(String queryName, Map<String, ?> params)
    {
        Validate.notEmpty(queryName);
        Validate.notEmpty(params);
        return executeQueryWithNamedParams(entityManager.createNamedQuery(queryName), params);
    }

    public <T> List<T> queryByNamedQuery(String queryName)
    {
        Validate.notEmpty(queryName);
        return executeQueryWithNamedParams(entityManager.createNamedQuery(queryName), new HashMap<String, Object>());
    }

    @SuppressWarnings({"unchecked"})
    public <T> T queryUniqueByNamedQueryAndNamedParams(String queryName, Map<String, ?> params)
    {
        Validate.notEmpty(queryName);
        Validate.notEmpty(params);
        List<T> resultList = (List<T>) queryByNamedQueryAndNamedParams(queryName, params);
        Validate.isTrue(resultList.isEmpty() || resultList.size() == 1, "Found more than one persistent instance with parameters " + params.toString());
        return resultList.size() == 1 ? resultList.get(0) : null;
    }

    @SuppressWarnings({"unchecked"})
    public <T> List<T> query(String queryString)
    {
        Validate.notEmpty(queryString);
        return entityManager.createQuery(queryString).getResultList();
    }

    public <T> T save(T entity)
    {
        Validate.notNull(entity);
        entityManager.persist(entity);
        return entity;
    }

    public <T> T saveAndRefresh(T entity)
    {
        // Save the entity.
        save(entity);

        // Flush (i.e. persist) the entity and re-load it to retrieve the create/update date that was populated by the database.
        entityManager.flush();
        entityManager.refresh(entity);

        // Return the persisted entity.
        return entity;
    }

    public <T> void delete(T entity)
    {
        Validate.notNull(entity);
        entityManager.remove(entity);

        // Flush to persist so we ensure that data integrity violations, etc. are thrown here rather than at the time of transaction commit.
        entityManager.flush();
    }

    /**
     * Executes a query with named parameters and returns the result list.
     *
     * @param query the query to execute.
     * @param params the named parameters.
     *
     * @return the list of results.
     */
    @SuppressWarnings({"unchecked"})
    private <T> List<T> executeQueryWithNamedParams(Query query, Map<String, ?> params)
    {
        Validate.notNull(query);
        Validate.notNull(params);
        if (params != null)
        {
            for (Map.Entry<String, ?> entry : params.entrySet())
            {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.getResultList();
    }
}


