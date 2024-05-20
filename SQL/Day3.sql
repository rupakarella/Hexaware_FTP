-- current date and time
select now();
select current_timestamp();

-- current date
select current_date();

-- current time
select current_time();

-- extracts specific part from date or time
select extract(month from now()) as month;

-- date value according to a specified format
select date_format(now(),'%d-%m-%y') as formatted_date;

-- difference between two dates or times
select datediff(now(),'2017-06-04') AS day_difference;
