CREATE TABLE IF NOT EXISTS `Card`
(
    `id`          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `object_id`   INTEGER                           NOT NULL,
    `theme_id`    INTEGER                           NOT NULL,
    `title`       TEXT,
    `object_date` TEXT,
    `url`         TEXT,
    FOREIGN KEY (`theme_id`) REFERENCES `Theme` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE  INDEX `index_Card_object_id` ON `Card` (`object_id`);

CREATE  INDEX `index_Card_theme_id` ON `Card` (`theme_id`);

CREATE  INDEX `index_Card_object_date` ON `Card` (`object_date`);

CREATE TABLE IF NOT EXISTS `Game`
(
    `id`           INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `player_id`    INTEGER                           NOT NULL,
    `theme_id`     INTEGER                           NOT NULL,
    `play_time`    INTEGER                           NOT NULL,
    `score`        INTEGER                           NOT NULL,
    `date_started` INTEGER                           NOT NULL,
    `date_ended`   INTEGER                           NOT NULL,
    `timestamp`    INTEGER,
    FOREIGN KEY (`theme_id`) REFERENCES `Theme` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`player_id`) REFERENCES `Player` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE  INDEX `index_Game_player_id` ON `Game` (`player_id`);

CREATE  INDEX `index_Game_theme_id` ON `Game` (`theme_id`);

CREATE  INDEX `index_Game_play_time` ON `Game` (`play_time`);

CREATE TABLE IF NOT EXISTS `Player`
(
    `id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name` TEXT
);

CREATE TABLE IF NOT EXISTS `Theme`
(
    `id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `title` TEXT
);



