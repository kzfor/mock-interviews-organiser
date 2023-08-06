create schema if not exists mock_interviews;
create schema if not exists mock_interviews_security;

create table mock_interviews.profiles (
    id bigserial primary key,
    username varchar(255) not null,
    vk_url varchar(255),
    telegram_url varchar(255)
);

create table mock_interviews.meetings (
    id bigserial primary key,
    organizer_id bigint references mock_interviews.profiles (id),
    topic varchar(255) not null,
    created_at timestamp,
    scheduled timestamp
);

create table mock_interviews_security.users (
    id bigserial primary key,
    username varchar(100) not null unique,
    password varchar(100) not null,
    roles varchar(255) not null,
    is_account_non_expired boolean not null,
    is_account_non_locked boolean not null,
    is_credentials_non_expired boolean not null,
    is_enabled boolean not null,
    profile_id bigint references mock_interviews.profiles (id)
);
