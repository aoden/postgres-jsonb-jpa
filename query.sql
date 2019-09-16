select info from public."employee"; 
select info->'address' as addresses from public."employee"; --return jsonb
select info->>'address' as addresses from public."employee"; --return value
select info->>'skills' as addresses from public."employee";
--nested jsonb query
select info->'additional_info'->'external' as additional_info from public."Employee";
-- jsonb in where clause
select * from public."employee" e where e.info->>'position' = 'dev';
--jsonb functions
select jsonb_array_length(e.info->'skills') from public."employee" e;
select jsonb_array_elements(e.info->'skills') from public."employee" e;-- break json array into rows
select distinct jsonb_array_elements(e.info->'skills') from public."employee" e;

--select dev with java and ruby skill
select * from public."employee" as e
	where e.info->>'position' = 'dev' 
	and e.info->'skills' @> '["ruby", "java"]';
	
--select dev with skill contains character(s): 'sca'
select * from public."employee" as e
	where e.info->>'position' = 'dev' 
	and e.info->>'skills' like '%sca%';
	
--select dev with java or ruby skill
select * from public."employee" as e
	where e.info->>'position' = 'dev' 
	and e.info->'skills' @>  any(array['"ruby"','"java"']::jsonb[]);
	
SELECT * FROM employee e 
    WHERE
        e.info->>'position' = 'dev' 
        AND e.info->'skills' @> ANY(CAST(ARRAY['"ruby"','"java"'] AS jsonb[]));

--select company that has dev with nodejs java skill
select * from public."company" com, jsonb_array_elements(com.employees) em 
	where em->'info'->'skills' @> '["nodejs", "java"]';
	
--select company that has dev with nodejs and java skill
select * from public."company" as com, jsonb_array_elements(com.employees) as em 
	where em->'info'->'skills' @> '["nodejs", "java"]';
	
--select company that has dev with kotlin or php skill
select * from public."company" as com, jsonb_array_elements(com.employees) as em 
	where em->'info'->'skills' @> ANY(CAST(ARRAY['"kotlin"','"php"'] AS jsonb[]));
 
 
 
