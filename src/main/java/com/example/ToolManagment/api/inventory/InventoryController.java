package com.example.ToolManagment.api.inventory;

import com.example.ToolManagment.api.inventory.dto.InventoryDtoAdd;
import com.example.ToolManagment.api.inventory.dto.InventoryDtoUpdate;
import com.example.ToolManagment.domain.inventory.Inventory;
import com.example.ToolManagment.domain.inventory.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")

public class InventoryController {
    final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    //    @GetMapping("/test")
//    public String inventoryTest(){
//        return "test";
//    }
    @GetMapping("/all-entries")
    public List<Inventory> getAllEntries() {
        return inventoryRepository.findAll();
    }

    @GetMapping("/{id}")
    Inventory getById(@PathVariable Integer id) {
        return inventoryRepository.findById(id).get();
    }

    @PostMapping("/add")
    Inventory add(@RequestBody InventoryDtoAdd commandDto) {
        Inventory inventoryToBeSaved = new Inventory();
        inventoryToBeSaved.setIdTool(commandDto.getIdTool());
        inventoryToBeSaved.setIdSite(commandDto.getIdSite());
        inventoryToBeSaved.setEntryDate(commandDto.getEntryDate());
        inventoryToBeSaved.setExitDate(commandDto.getExitDate());
        return inventoryRepository.save(inventoryToBeSaved);
    }

    @PostMapping("/update/{id}")
    Inventory update(@PathVariable Integer id,
                     @RequestBody InventoryDtoUpdate updateDto){
        Inventory invetoryToUpdate = inventoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("This entry does not exist"));
        invetoryToUpdate.setExitDate(updateDto.getExitDate());

        return inventoryRepository.save(invetoryToUpdate);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Integer id){
        Inventory entryToDelete = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
        inventoryRepository.delete(entryToDelete);
        return ResponseEntity.ok("The inventory entry has been deleted");
    }


}
