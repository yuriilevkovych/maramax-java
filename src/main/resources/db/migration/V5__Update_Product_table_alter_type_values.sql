UPDATE product SET type='POS_MATERIALS' WHERE type='pos-materials';
UPDATE product SET type='CASHED' WHERE type='cashed';
UPDATE product SET type='CARTBOARD' WHERE type='cartboard';
UPDATE product SET type='CORRUGATED' WHERE type='corrugated';

ALTER TABLE product ADD COLUMN IF NOT EXISTS img_path varchar(255);
UPDATE product SET img_path=concat('/img/maramax-images-compressed/', type, '/', number, '.png');
