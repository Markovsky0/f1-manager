package pl.f1manager.mappers;

public interface GenericMapper<T, E> {
    T toDto(E entity);

    E toEntity(T dto);
}
