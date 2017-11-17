CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  organization VARCHAR(100),
  login VARCHAR(100),
  role VARCHAR (100),
  password_hash VARCHAR(100)
);

CREATE TABLE domains (
  id SERIAL PRIMARY KEY,
  domain_values VARCHAR(500)
);

CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  author_id INTEGER,
  description VARCHAR(500),
  attribute_domain_id INTEGER,
  instructions_file_url VARCHAR(100),

  FOREIGN KEY (author_id) REFERENCES users(id),
  FOREIGN KEY (attribute_domain_id) REFERENCES domains(id)
);

CREATE TABLE documents (
  id SERIAL PRIMARY KEY,
  task_id INTEGER,
  file_name VARCHAR(100),
  type VARCHAR(100),
  folder_name VARCHAR(200),
  size INTEGER,
  url VARCHAR(100),

  FOREIGN KEY (task_id) REFERENCES tasks(id)
);

CREATE TABLE precedents (
  user_id INTEGER,
  task_id INTEGER,
  document_id INTEGER,
  fragment VARCHAR(500),
  label_value VARCHAR(100),

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (task_id) REFERENCES tasks(id),
  FOREIGN KEY (document_id) REFERENCES documents(id)
);

CREATE TABLE task_assignments (
  user_id INTEGER,
  task_id INTEGER,

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (task_id) REFERENCES tasks(id)
);

CREATE TABLE complaints (
  user_id INTEGER,
  task_id INTEGER,
  description VARCHAR(500),

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (task_id) REFERENCES tasks(id)
);

CREATE TABLE completed_tasks (
  task_id INTEGER,
  user_id INTEGER,

  FOREIGN KEY (task_id) REFERENCES tasks(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);