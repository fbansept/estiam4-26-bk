INSERT INTO role (name) VALUES
   ('admin'),
   ('moderator'),
   ('customer');

INSERT INTO app_user (email, password, role_id) VALUES
    ('a@a.com', 'root', 1),
    ('b@b.com', 'root', 2),
    ('c@c.com', 'root', 3);

INSERT INTO project (name, owner_id) VALUES
    ('gobelet', 2),
    ('vase', 3),
    ('visage', 3);

INSERT INTO tag (name) VALUES
     ('deco'),
     ('entreprise'),
     ('fleurs');

INSERT INTO tag_project (project_id, tag_id) VALUES
   (1, 1),
   (1, 2),
   (2, 1),
   (2, 3);