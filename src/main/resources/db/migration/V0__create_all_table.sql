CREATE TABLE IF NOT EXISTS commment (comment_id bigint not null auto_increment, comment_contents varchar(255) not null, created_date datetime(6) not null, modified_date datetime(6) not null, task_id bigint, member_id bigint, primary key (comment_id))
;
CREATE TABLE IF NOT EXISTS member (member_id bigint not null auto_increment, email varchar(255) not null, nickname varchar(255) not null, member_auth_id bigint, payment_id bigint, primary key (member_id))
;
CREATE TABLE IF NOT EXISTS member_study_group (member_study_group_id bigint not null auto_increment, is_active varchar(255) not null, member_id bigint, study_group_id bigint, primary key (member_study_group_id))
;
CREATE TABLE IF NOT EXISTS member_auth (member_auth_id bigint not null auto_increment, auth_token varchar(255), created_date datetime(6), modified_date datetime(6), primary key (member_auth_id))
;
CREATE TABLE IF NOT EXISTS payment (payment_type varchar(31) not null, payment_id bigint not null auto_increment, payment_date datetime(6), payment_key varchar(255), primary key (payment_id))
;
CREATE TABLE IF NOT EXISTS payment_history (id bigint not null auto_increment, created_date datetime(6), modified_date datetime(6), payment_id bigint, primary key (id))
;
CREATE TABLE IF NOT EXISTS sprint (sprint_id bigint not null auto_increment, end_at datetime(6) not null, start_at datetime(6) not null, study_group_id bigint, primary key (sprint_id))
;
CREATE TABLE IF NOT EXISTS study_group (study_group_id bigint not null auto_increment, end_point varchar(255) not null, study_group_name varchar(255) not null, primary key (study_group_id))
;
CREATE TABLE IF NOT EXISTS task (task_id bigint not null auto_increment, created_date datetime(6) not null, deposit integer not null, end_date datetime(6) not null, is_task_success varchar(255) not null, start_date datetime(6) not null, task_contents varchar(255) not null, task_title varchar(255) not null, approver_id bigint, drafter_id bigint, sprint_id bigint, primary key (task_id))
;


ALTER TABLE commment ADD CONSTRAINT FK_COMMENT_TASK FOREIGN KEY (task_id) REFERENCES task (task_id)
;
ALTER TABLE commment ADD CONSTRAINT FK_COMMENT_MEMBER FOREIGN KEY (member_id) REFERENCES member (member_id)
;
ALTER TABLE member ADD CONSTRAINT FK_MEMBER_MEMBER_AUTH FOREIGN KEY (member_auth_id) REFERENCES member_auth (member_auth_id)
;
ALTER TABLE member ADD CONSTRAINT FK_MEMBER_PAYMENT FOREIGN KEY (payment_id) REFERENCES payment (payment_id)
;
ALTER TABLE member_study_group ADD CONSTRAINT FK_MEMBER_MEMBERSTUDYGROUP FOREIGN KEY (member_id) REFERENCES member (member_id)
;
ALTER TABLE member_study_group ADD CONSTRAINT FK_STUDYGROUP_MEMBERSTUDYGROUP FOREIGN KEY (study_group_id) REFERENCES study_group (study_group_id)
;
ALTER TABLE payment_history ADD CONSTRAINT FK_PAYMENT_HISTORY_PAYMENT FOREIGN KEY (payment_id) REFERENCES payment (payment_id)
;
ALTER TABLE sprint ADD CONSTRAINT fk_studygroup_sprint FOREIGN KEY (study_group_id) REFERENCES study_group (study_group_id)
;
ALTER TABLE task ADD CONSTRAINT FK_TASK_APPROVER FOREIGN KEY (approver_id) REFERENCES member (member_id)
;
ALTER TABLE task ADD CONSTRAINT FK_TASK_DRAFTER FOREIGN KEY (drafter_id) REFERENCES member (member_id)
;
ALTER TABLE task ADD CONSTRAINT fk_sprint_task FOREIGN KEY (sprint_id) REFERENCES sprint (sprint_id)
;
