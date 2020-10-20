-- THIS IS THE POPULATION SCRIP FOR THE TESTING H2 DATABASE, DO NOT CHANGE VALUES --
INSERT INTO activities (id, name, description, price, group_size, duration, start_time, age_restriction,
                               height_restriction, full_description, img_link1, img_link2)
VALUES (1, 'GoKart', 'Accelerate your dreams!', 0, '1-100', 30, 'Mondays from 0-0', 10, 150, 'blabla',
        'https://images-na.ssl-images-amazon.com/images/I/81w82K3hBrL._AC_SL1500_.jpg',
        'https://cdn1.i-scmp.com/sites/default/files/images/methode/2018/02/27/ed5638d2-1b97-11e8-804d-87987865af94_1280x720_165938.jpg'),
       (2, 'Paintball', 'its like COD', 400, '10-40', 30, 'Mondays from 0-0', 15, 150, 'blabla',
        'https://i1.sndcdn.com/artworks-000237803152-a076c2-t500x500.jpg',
        'https://i.ytimg.com/vi/n4YV_eXVDgg/maxresdefault.jpg'),
       (3, 'Sumo Wrestling', 'its like wrestling but you are fat', 400, '2-4', 10, 'Wednesday from 0-0', 15, 150,
        'blabla', 'https://i.ytimg.com/vi/Q2k39b2utf8/maxresdefault.jpg',
        'https://www.nintendoenthusiast.com/wp-content/uploads/2019/07/mariowrestling.jpg'),
       (4, 'Mini-Golf', 'Explore our indoor adventure mini-golf course. Cheapest 18-hole putting in town!', 0, '1-100',
        30, 'Tuesdays from 0-0', 10, 150, 'blabla',
        'https://gamespot1.cbsistatic.com/uploads/scale_landscape/225/2256286/2515598-mariogolf_wt_1920_042314.jpg',
        'https://i.ytimg.com/vi/X7gVpsP5IqY/maxresdefault.jpg'),
       (5, 'Raveyard', 'Celebrate Spooktober in style at our local graveyard', 69, '1-101',
        600, 'Saturdays from 0-0', 10, 1, 'Shae your inner skeleton at the spookiest rave of the year! Indulge in drinking red cocktails from fake skulls, strangers biting you randomly and the animated corpses looking for tasty brainzz',
        'https://i.ytimg.com/vi/wI4iv5E8XLI/maxresdefault.jpg',
        'https://www.residentadvisor.net/images/events/flyer/2019/7/hr-0705-1286871-0-front.gif');

INSERT INTO activity_schedule (id, time)
VALUES (1, '09:00:00'),
       (2, '12:00:00'),
       (3, '18:00:00'),
       (4, '21:00:00');