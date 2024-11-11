package com.example.codoceanbmongo.infras.commonresponse;

import java.util.List;

public record ListResponse<T>(
        List<T> list,
        int page,
        int totalPages
) {}
