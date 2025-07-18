CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE studies (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(100) NOT NULL,
                         description TEXT NOT NULL,
                         max_members INT NOT NULL,
                         deadline DATE NOT NULL,
                         creator_id BIGINT NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         FOREIGN KEY (creator_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE study_applications (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    study_id BIGINT NOT NULL,
                                    user_id BIGINT NOT NULL,
                                    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    UNIQUE KEY unique_study_user (study_id, user_id),
                                    FOREIGN KEY (study_id) REFERENCES studies(id) ON DELETE CASCADE,
                                    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_studies_title ON studies(title);
CREATE INDEX idx_studies_creator_id ON studies(creator_id);
CREATE INDEX idx_users_username ON users(username);
