package com.ratel.common.base;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author daiyun
 * @date 2020/8/19
 */
public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

	protected abstract JpaRepository<T, ID> getJpaRepository();

	@Override
	public <S extends T> S save(S entity) {
		return getJpaRepository().save(entity);
	}

	@Override
	public T findById(ID id) {
		return getJpaRepository().findById(id).orElse(null);
	}

	@Override
	public long count() {
		return getJpaRepository().count();
	}

	@Override
	public void deleteById(ID id) {
		getJpaRepository().deleteById(id);
	}
}
