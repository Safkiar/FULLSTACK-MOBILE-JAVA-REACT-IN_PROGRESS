CREATE TABLE r1_incomingevents (
                                   ine_id         UUID PRIMARY KEY,
                                   ine_title      VARCHAR(255) NOT NULL,
                                   ine_text       VARCHAR(500), -- Opis może być dłuższy, zostawiłem jako opcjonalny (może być NULL), jeśli wolisz wymagany dodaj NOT NULL
                                   ine_date       TIMESTAMP NOT NULL, -- Kiedy wydarzenie ma miejsce
                                   ine_created_at TIMESTAMP NOT NULL,
                                   ine_updated_at TIMESTAMP NOT NULL,
                                   ine_user_id    UUID NULL,
                                   ine_version    INT NOT NULL DEFAULT 0
);

CREATE INDEX idx_r1ine_user_date ON r1_incomingevents (ine_user_id, ine_date);