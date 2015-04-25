package org.cccgermantown.web.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

/**
 * Functionality for a generic JPA DAO.
 */
public interface BaseJpaDao
{
    /**
     * Gets the entity manager instance.
     *
     * @return the entity  manager.
     */
    public EntityManager getEntityManager();

    /**
     * Get an entity based on its class and entity Id.
     *
     * @param entityClass the entity class.
     * @param entityId the entity Id.
     * @param <T> the type of class.
     *
     * @return the entity.
     */
    public <T> T findById(Class<T> entityClass, Object entityId);

    /**
     * Gets a list of entities based on the entity class.
     *
     * @param entityClass the entity class.
     * @param <T> the type of class.
     *
     * @return the list of entities.
     */
    public <T> List<T> findAll(Class<T> entityClass);

    /**
     * Finds a collection of entities based on an entity class name and named parameters.
     *
     * @param entityClass the entity class to retrieve.
     * @param params the named parameters.
     * @param <T> the type of class.
     *
     * @return the list of entities.
     */
    public <T> List<T> findByNamedProperties(Class<T> entityClass, Map<String, ?> params);

    /**
     * Finds an entity based on an entity class name and named parameters.  If more than 1 entity is found, an exception is returned.
     *
     * @param entityClass the entity class to retrieve.
     * @param params the named parameters.
     * @param <T> the type of class.
     *
     * @return the entity.
     */
    public <T> T findUniqueByNamedProperties(Class<T> entityClass, Map<String, ?> params);

    /**
     * Executes a query string with a named set of parameters.
     *
     * @param queryString the query string.
     * @param params the named parameter map.
     * @param <T> the type of class to be returned.
     *
     * @return the results of the query.
     */
    public <T> List<T> queryByNamedParams(String queryString, Map<String, ?> params);

    /**
     * Executes a named query with a named set of parameters.
     *
     * @param queryName the query name of the query to execute.
     * @param params the named parameter map.
     * @param <T> the type of class to be returned.
     *
     * @return the results of the query.
     */
    public <T> List<T> queryByNamedQueryAndNamedParams(String queryName, Map<String, ?> params);

    /**
     * Executes a named query with no parameters.
     *
     * @param queryName the query name of the query to execute.
     * @param <T> the type of class to be returned.
     *
     * @return the results of the query.
     */
    public <T> List<T> queryByNamedQuery(String queryName);

    /**
     * Executes a named query with a named set of parameters.
     *
     * @param queryName the query name of the query to execute.
     * @param params the named parameter map.
     * @param <T> the type of class to be returned.
     *
     * @return the single entity returned by the query.
     */
    public <T> T queryUniqueByNamedQueryAndNamedParams(String queryName, Map<String, ?> params);

    /**
     * Executes a query string and returns the results.
     *
     * @param queryString the query string.
     * @param <T> the type of entity being returned.
     *
     * @return the list of entities.
     */
    public <T> List<T> query(String queryString);

    /**
     * Saves an entity.
     *
     * @param entity the entity to save.
     * @param <T> the type of entity.
     *
     * @return the saved entity.
     */
    public <T> T save(T entity);

    /**
     * Saves, flushes, and refreshes an entity.
     *
     * @param entity the entity to save.
     * @param <T> the type of entity.
     *
     * @return the saved entity.
     */
    public <T> T saveAndRefresh(T entity);

    /**
     * Deletes an entity.
     *
     * @param entity the entity to delete.
     * @param <T> the type of entity.
     */
    public <T> void delete(T entity);
}


