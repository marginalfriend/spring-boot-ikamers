package io.abun.springbootikamers.Constants;

public record PagingResponse(
        Integer totalPages,
        Long totalElements,
        Integer page,
        Integer size,
        Boolean hasNext,
        Boolean hasPrevious
) {
}
