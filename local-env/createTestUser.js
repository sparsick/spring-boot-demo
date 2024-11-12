db.getSiblingDB('admin').auth(
    process.env.MONGO_INITDB_ROOT_USERNAME,
    process.env.MONGO_INITDB_ROOT_PASSWORD
);

db.createUser(
    {
        user: "test",
        pwd: "test123",
        roles: [
            { role: "readWrite", db: "test" }
        ]
    });