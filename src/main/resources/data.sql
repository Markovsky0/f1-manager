-- koszty i statystyki do ustalenia, domyślnie 1 000 000
insert into f1_manager.engines (brand, performance, reliability, fuel_usage, cost) values ('Mercedes', 8, 6, 6, 1000000);
insert into f1_manager.engines (brand, performance, reliability, fuel_usage, cost) values ('Ferrari', 10, 8, 8, 1000000);
insert into f1_manager.engines (brand, performance, reliability, fuel_usage, cost) values ('Honda', 7, 8, 5, 1000000);
insert into f1_manager.engines (brand, performance, reliability, fuel_usage, cost) values ('Renault', 7, 5, 7, 1000000);

insert into f1_manager.tyres (brand, performance_dry, performance_wet, durability, warmup_time, optimum_temp, cost) values ('Pirelli', 9, 8, 7, 6, 30, 500000);

insert into f1_manager.sponsors (brand, country, category, signature_amount, amount_per_race, reputation, patience) values ('Red Bull', 'Austria', 'PLACEHOLDER', 5000000, 1000000, 10, 10);

