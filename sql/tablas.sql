------------- MODULO PADRON -------------
create table pdr_familias (
	id serial,
	descripcion varchar(255) not null,
	estado_id SMALLINT not null default 0,
	padre_id bigint(20) unsigned,

	primary key(id)
) ENGINE=InnoDB;

create table pdr_marcas (
	id serial,
	descripcion varchar(255) not null,
	alias char(4) not null,
	estado_id SMALLINT not null default 0,
	ultimo_nro_art integer(10) not null default 0,

	primary key(id),
	unique(alias)
) ENGINE=InnoDB;

create table pdr_talles (
	id serial,
	descripcion varchar(10) not null,
	estado_id SMALLINT not null default 0,

    primary key(id),
	unique(descripcion, estado_id)
) ENGINE=InnoDB;

create table pdr_articulos (
	id serial,
	descripcion varchar(255) not null,
	estado_id SMALLINT not null default 0,
	familia_id bigint(20) unsigned,
	marca_id bigint(20) unsigned,
	serial_number varchar(13) default '',
	code integer(13) unsigned not null,

	primary key(id),
	index(familia_id),
	index(marca_id),
	foreign key(familia_id) references pdr_familias(id),
	foreign key(marca_id) references pdr_marcas(id)
) ENGINE=InnoDB;

create table pdr_precios (
	id serial,
	estado_id SMALLINT not null default 0,
	articulo_id bigint(20) unsigned,
	talle_id bigint(20) unsigned,
	precio decimal(10,3) unsigned default 0,

	primary key(id),
	unique index (articulo_id, talle_id),
	index(articulo_id),
	foreign key(articulo_id) references pdr_articulos(id),
	foreign key(talle_id) references pdr_talles(id)
) ENGINE=InnoDB;


------------- MODULO DE STOCK ------------- 
create table mov_stock (
	articulo_id bigint(20) unsigned,
	talle_id bigint(20) unsigned,
	estado_id SMALLINT not null default 0,
	precio decimal(10,3) unsigned default 0,
	cantidad integer unsigned default 0,

	primary key(articulo_id, talle_id),
	foreign key(articulo_id) references pdr_articulos(id),
	foreign key(talle_id) references pdr_talles(id) 
) ENGINE=InnoDB;


