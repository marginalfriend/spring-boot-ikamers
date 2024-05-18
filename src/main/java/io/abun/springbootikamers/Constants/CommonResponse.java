package io.abun.springbootikamers.Constants;

public record CommonResponse<T>(
        Integer         statusCode,
        String          message,
        T               data,
        PagingResponse  paging
) {
}
