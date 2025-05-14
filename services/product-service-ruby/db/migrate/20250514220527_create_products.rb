class CreateProducts < ActiveRecord::Migration[8.0]
  def change
    create_table :products do |t|
      t.string :description
      t.float :price
      t.string :name

      t.timestamps
    end
  end
end
