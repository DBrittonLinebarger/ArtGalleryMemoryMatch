##DDL For Data Model
```sql
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

CREATE INDEX `index_Card_object_id` ON `Card` (`object_id`);

```