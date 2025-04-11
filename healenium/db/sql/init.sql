CREATE USER healenium_user WITH PASSWORD 'shravan'; -- Replace 'your_password' with a strong password
CREATE SCHEMA healenium AUTHORIZATION healenium_user;
GRANT USAGE ON SCHEMA healenium TO healenium_user;