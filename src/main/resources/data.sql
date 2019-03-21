INSERT INTO oauth_client_details (
                                  oauth_client_name,
                                  client_secret,
                                  web_server_redirect_uri,
                                  scope,
                                  access_token_validity,
                                  refresh_token_validity,
                                  resource_ids,
                                  authorized_grant_types,
                                  additional_information) VALUES (
                                                                  'web',
                                                                  '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu',
                                                                  'http://localhost:8080/user_protal',
                                                                  'READ,WRITE',
                                                                  '3600',
                                                                  '10000',
                                                                  'administration,page_view',
                                                                  'authorization_code,password,refresh_token,implicit',
                                                                  '{}');


INSERT INTO PERMISSION (NAME) VALUES
('CREATE_PROFILE'),
('READ_PROFILE'),
('UPDATE_PROFILE'),
('DELETE_PROFILE');

INSERT INTO role (NAME) VALUES
('ROLE_ADMIN'),('ROLE_OPERATOR');

INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
(1,1), /*create-> admin */
(2,1), /* read admin */
(3,1), /* update admin */
(4,1), /* delete admin */
(2,2),  /* read operator */
(3,2);  /* update operator */

insert into user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('1', 'IsuruK','{bcrypt}$2a$10$ODGwrk2ufy5d7T6afmACwOA/6j6rvXiP5amAMt1YjOQSdEw44QdqG', 'isuru.k@synergentl.com', '1', '0', '0', '0');
insert into  user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('2', 'RuwanK', '{bcrypt}$2a$10$wQ8vZl3Zm3.zDSIcZEYym.bGq3fPMJXH9k.Vhudcfr6O6KQwDPSt6','ruwan.k@synergentl.com', '1', '0', '0', '0');

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
VALUES
(1, 1) /* isuruk-admin */,
(2, 2) /* ruwank-operator */ ;