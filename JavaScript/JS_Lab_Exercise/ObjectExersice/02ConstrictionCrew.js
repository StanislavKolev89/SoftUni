function solve(object){
  let obj = Object.assign({},object); 
  if(obj.dizziness == true){
      obj.levelOfHydrated+=obj.weight * 0.1 * obj.experience;
      obj.dizziness = false;
  }
  console.log(obj);
}

solve({ weight: 80,
    experience: 1,
    levelOfHydrated: 0,
    dizziness: true });

    solve({ weight: 120,
        experience: 20,
        levelOfHydrated: 200,
        dizziness: true });
        
        solve({ weight: 95,
            experience: 3,
            levelOfHydrated: 0,
            dizziness: false });