CREATE TABLE r1_checkboxes (
    chk_id         UUID PRIMARY KEY,
    chk_title      VARCHAR(255) NOT NULL,
    chk_text       VARCHAR(500) NOT NULL,
    chk_mark       BOOLEAN NOT NULL DEFAULT FALSE,
    chk_created_at TIMESTAMP NOT NULL,
    chk_updated_at TIMESTAMP NOT NULL,
    chk_user_id    UUID NULL,
    chk_version    INT NOT NULL DEFAULT 0
);

CREATE INDEX idx_r1chk_user_mark ON r1_checkboxes (chk_user_id, chk_mark);