-- schema used for h2 initialization
create schema if not exists f1_manager;

create table f1_manager.engines
(
    brand       varchar(32) primary key,
    performance smallint not null,
    reliability smallint not null,
    fuel_usage  smallint not null,
    price       numeric  not null,

    constraint performance_range check (performance between 1 and 10),
    constraint reliability_range check (reliability between 1 and 10),
    constraint fuel_usage_range check (fuel_usage between 1 and 10)
);

create table f1_manager.tyres
(
    brand           varchar(32) primary key,
    performance_dry smallint not null,
    performance_wet smallint not null,
    durability      smallint not null,
    warmup_time     smallint not null,
    optimal_temp    smallint not null, -- temperature in Celsius
    price           numeric  not null,

    constraint performance_dry_range check (performance_dry between 1 and 10),
    constraint performance_wet_range check (performance_wet between 1 and 10),
    constraint durability_range check (durability between 1 and 10),
    constraint warmup_time_range check (warmup_time between 1 and 10),
    constraint optimal_temp_range check (optimal_temp between 10 and 40)
);

create table f1_manager.sponsors
(
    brand            varchar(32) primary key,
    country          varchar(32) not null,
    category         varchar(32) not null default 'PLACEHOLDER',
    signature_amount numeric     not null,
    amount_per_race  numeric     not null,
    reputation       smallint    not null,
    patience         smallint    not null,

--     constraint check_category check (sponsors.category in ('PLACEHOLDER')), -- todo jak będą określone kategorie sponsorów
    constraint category_uppercase check (category = upper(category)),
    constraint reputation_range check (reputation between 1 and 10),
    constraint patience_range check (patience between 1 and 10)
);

create table f1_manager.facilities
(
    id                    serial primary key,
    factory               smallint not null default 1,
    design_centre         smallint not null default 1,
    wind_tunnel           smallint not null default 0,
    quality_department    smallint not null default 0,
    innovation_department smallint not null default 0,
    simulator             smallint not null default 0,
    weather_station       smallint not null default 0,
    pit_stop_centre       smallint not null default 0,

    constraint factory_range check (factory between 1 and 3),
    constraint design_centre_range check (design_centre between 1 and 3),
    constraint wind_tunnel_range check (wind_tunnel between 0 and 3),
    constraint quality_department_range check (quality_department between 0 and 3),
    constraint innovation_department_range check (innovation_department between 0 and 3),
    constraint simulator_range check (simulator between 0 and 3),
    constraint weather_station_range check (weather_station between 0 and 3),
    constraint pit_stop_centre_range check (pit_stop_centre between 0 and 3)
);

create table f1_manager.drivers
(
    id                serial primary key,
    first_name        varchar(32),
    last_name         varchar(32) not null,
    nationality       varchar(32) not null,
    age               smallint    not null,
    gender            varchar(16) not null,
    status            varchar(16) not null default 'INACTIVE',
    quickness         smallint    not null,
    focus             smallint    not null,
    overtaking        smallint    not null,
    driving_in_wet    smallint    not null,
    experience        smallint    not null,
    technical_insight smallint    not null,
    agility           smallint    not null, -- sprawność
    popularity        smallint    not null,
    morale            smallint    not null,

    constraint status_check check (status in ('INACTIVE', 'ACTIVE', 'RETIRED')),
    constraint status_uppercase check (status = upper(status)),
    constraint gender_check check (gender in ('MALE', 'FEMALE', 'OTHER')),
    constraint gender_uppercase check (gender = upper(gender))
    constraint age_check check (age >= 18),
    constraint quickness_range check (quickness between 1 and 100),
    constraint focus_range check (focus between 1 and 100),
    constraint overtaking_range check (overtaking between 1 and 100),
    constraint driving_in_wet_range check (driving_in_wet between 1 and 100),
    constraint experience_range check (experience between 1 and 100),
    constraint technical_insight_range check (technical_insight between 1 and 100),
    constraint agility_range check (agility between 1 and 100),
    constraint popularity_range check (popularity between 1 and 100),
    constraint morale_range check (morale between 1 and 5)
);

create table f1_manager.teams
(
    id              serial primary key,
    name            varchar(64) not null unique,
    country         varchar(32) not null,
    primary_color   varchar(7)  not null, -- kolory w formacie hex, np. #FF5733
    secondary_color varchar(7)  not null, -- kolory w formacie hex, np. #FF5733
    engine_brand    varchar(32),
    tyre_brand      varchar(32),

    constraint fk_engine_brand foreign key (engine_brand) references f1_manager.engines (brand) on delete set null,
    constraint fk_tyre_brand foreign key (tyre_brand) references f1_manager.tyres (brand) on delete set null
);

create table f1_manager.contracts
(
    team_id    serial   not null,
    driver_id  serial   not null,
    length     smallint not null,                                              -- długość kontraktu w wyścigach
    salary     numeric  not null,                                              -- pensja kierowcy
    start_date timestamp without time zone not null default current_timestamp, -- data zawarcia kontraktu

    constraint pk_team_drivers primary key (team_id, driver_id),
    constraint fk_team_id foreign key (team_id) references f1_manager.teams (id) on delete cascade,
    constraint fk_driver_id foreign key (driver_id) references f1_manager.drivers (id) on delete cascade,
    constraint driver_id_unique unique (driver_id)
);
-- todo tabela contract_proposals, która będzie zawierała propozycje kontraktów dla kierowców

create table f1_manager.team_facilities
(
    team_id     serial not null,
    facility_id serial not null,

    constraint pk_team_facilities primary key (team_id, facility_id),
    constraint fk_tf_team_id foreign key (team_id) references f1_manager.teams (id) on delete cascade,
    constraint fk_tf_facility_id foreign key (facility_id) references f1_manager.facilities (id) on delete cascade
);









