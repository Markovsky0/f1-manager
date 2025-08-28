-- koszty i statystyki do ustalenia, domyślnie 1 000 000
insert into f1_manager.engines (brand, performance, reliability, fuel_usage, price) values ('Mercedes', 8, 6, 6, 1000000);
insert into f1_manager.engines (brand, performance, reliability, fuel_usage, price) values ('Ferrari', 10, 8, 8, 1000000);
insert into f1_manager.engines (brand, performance, reliability, fuel_usage, price) values ('Honda', 7, 8, 5, 1000000);
insert into f1_manager.engines (brand, performance, reliability, fuel_usage, price) values ('Renault', 7, 5, 7, 1000000);

insert into f1_manager.tyres (brand, performance_dry, performance_wet, durability, warmup_time, optimal_temp, price) values ('Pirelli', 9, 8, 7, 6, 30, 500000);

insert into f1_manager.sponsors (brand, country, category, signature_amount, amount_per_race, reputation, patience) values ('Red Bull', 'Austria', 'PLACEHOLDER', 5000000, 1000000, 10, 10);

insert into f1_manager.drivers (first_name, last_name, nationality, age, gender, quickness, focus, overtaking, driving_in_wet, experience, technical_insight, agility, popularity, morale)
values ('Robert', 'Kubica', 'Poland', 38, 'MALE', 90, 85, 80, 75, 95, 90, 85, 80, 4);
