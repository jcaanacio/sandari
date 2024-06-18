CREATE TABLE signature (
    signature_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    closing_remarks VARCHAR(255) UNIQUE NOT NULL,
    department_name VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);



CREATE TABLE spiels (
    spiel_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    signature_id INT NOT NULL,
    header VARCHAR(255) UNIQUE NOT NULL,
    title VARCHAR(255) UNIQUE NOT NULL,
    content VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (signature_id) REFERENCES signature(signature_id)
);
