package com.opencode.alumxbackend.users.service;

import com.opencode.alumxbackend.users.dto.UserAuraResponse;

public interface UserAuraService {

    UserAuraResponse getAuraResponse(Long userId);
}
