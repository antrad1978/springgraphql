# JWT based security for GraphQL

This sample project shows how to manage a Graphql
endpoint using JWT and Spring security annotations.


You can obtain a token calling this url:

http://127.0.0.1:8080/web/graphiql

and using this query:

mutation{
  signin(username:"user", password:"pass")
}

After that you obtain an access token you can query:

query {
  vehicles{
    id
    type
    brandName
  }
}

The security is managed via Spring annotations:

    @PreAuthorize("hasRole('USER')")
    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }
    
In this sample we coded ROLE directly in UserDetails inherited class:

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority("ROLE_USER"));

        return list;
    }

PS:Enable stateless sessions to be sure that context is not saved during calls 