package com.vetcare.grupo_3.Exception;

import java.time.LocalDateTime;

public record ErrorDetails(
        LocalDateTime timestamp,
        String message,
        String details
) {}
